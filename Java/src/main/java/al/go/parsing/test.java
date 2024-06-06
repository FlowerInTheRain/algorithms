package al.go.parsing;

import java.util.*;

public class test {
	public static void main(String[] args) {
		String input = """
quarkus.devservices.enabled=false
quarkus.http.port=80
quarkus.application.name=petpals-caregivers
quarkus.http.host=0.0.0.0
quarkus.oidc.enabled=false
api.key=caregivers-0.1.0
azure.tenantid=${TENANT-ID}
azure.clientid=${CLIENT-ID}
azure.secret=${SECRET}
quarkus.package.type=uber-jar
quarkus.swagger-ui.always-include=true
quarkus.swagger-ui.path=/swagger
quarkus.oidc.auth-server-url=http://keycloak:8080/auth/realms/dbk
quarkus.datasource.db-kind=pg
quarkus.datasource.jdbc.url=jdbc:postgresql://
quarkus.hibernate-orm.multitenant=DATABASE
quarkus.hibernate-orm.database.generation=validate
quarkus.hibernate-orm.log.sql=true
quarkus.jacoco.enabled=true
quarkus.jacoco.report=true
quarkus.jacoco.excludes=**/persistence/entities/*,**/domain/pojo/*,**/application/dto/*
quarkus.log.console.format=%d{HH:mm:ss} %-5p [%c{2.}] %s%e%n""";
		List<Property> properties=new ArrayList<>();
		List<String> initialArray = Arrays.asList(input.split("\n"));
		Collections.sort(initialArray);
		List<String> splitProperties = Arrays.asList(initialArray.get(0).split("=")[0].split("\\."));
		
		System.out.println(extracted(initialArray, splitProperties, properties, null, properties));
		
	}
	
	private static List<Property> extracted(List<String> initialArray,
											List<String> splitProperty, List<Property> parentProperties,
											Property parentProperty, List<Property> rootProperties) {
		if(initialArray.isEmpty()){
			return rootProperties;
		} else {
			String value = initialArray.get(0).split("=")[1];
			if(parentProperty != null){
				if(splitProperty.size() == 2){
					List<String> newSplitProperty;
					if(initialArray.size() > 1){
						newSplitProperty = Arrays.asList(initialArray.get(1).split("=")[0].split("\\."));
					} else {
						newSplitProperty = Arrays.asList(initialArray.get(0).split("=")[0].split("\\."));
					}
					var property = new Property(splitProperty.get(1));
					property.setValue(value);
					property.setChildren(new ArrayList<>());
					parentProperty.getChildren().add(property);
				
					if(newSplitProperty.contains(parentProperty.getName())){
						System.out.println(newSplitProperty);
						System.out.println(splitProperty);
						System.out.println(parentProperty.getName());
						return extracted(initialArray.subList(1,initialArray.size())
								, newSplitProperty.subList(newSplitProperty.indexOf(
										parentProperty.getName()
								), newSplitProperty.size()),
										 parentProperty.getChildren(), property, rootProperties);
					}
					return extracted(initialArray.subList(1,initialArray.size())
							, newSplitProperty,
									 rootProperties, null, rootProperties);
				} else {
					var property = new Property(splitProperty.get(1));
					property.setChildren(new ArrayList<>());
					parentProperty.getChildren().add(property);
					return extracted(initialArray,
									 splitProperty.subList(1, splitProperty.size())
							, parentProperty.getChildren(),
									 property,rootProperties);
				}
			} else {
				var property = new Property(splitProperty.get(0));
				property.setChildren(new ArrayList<>());
				if(rootProperties.stream().filter(property1 -> property1.getName().equals(property.getName())).findFirst().isEmpty()){
					rootProperties.add(property);
					return extracted(initialArray,
									 splitProperty,property.getChildren(),
									 property, rootProperties);
				} else {
					var prop =
							rootProperties.stream().filter(property1 -> property1.getName().equals(property.getName())).findFirst().get();
					return extracted(initialArray,
									 splitProperty,prop.getChildren(),
									 prop, rootProperties);
				}
				
			}
		}
	}
	
	
}