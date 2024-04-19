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
		List<Property> properties	=	new ArrayList<>();
		List<String> list = Arrays.asList(input.split("\n"));
		String res = "";
		for(int i = 0; i < list.size(); ++i) {
			var splitProperty = list.get(i).split("=")[0].split("\\.");
			
			if(properties.stream().filter(prop -> Objects.equals(prop.getName(), splitProperty[0])).findFirst().isEmpty()){
				List<Property> childProperties	=	new ArrayList<>();
				Property toAdd = new Property(splitProperty[0]);
				toAdd.setChildren(childProperties);
				properties.add(toAdd);
				if(splitProperty.length - 1 == 1) {
					var inner = splitProperty[0] + ": {\n\t" + splitProperty[1] + ":"+ list.get(i).split("=")[1]+",\n";
					for(int c =i + 1; c < list.size(); ++c){
						var splitPropertyInner = list.get(c).split("=")[0].split("\\.");
						
						if(splitPropertyInner[0].equals(splitProperty[0]) && splitPropertyInner.length - 1 == 1){
							var innerVals = "\t"+splitPropertyInner[1] + ":"+ list.get(c).split("=")[1]+",\n";
							inner += innerVals;
							childProperties.add(toAdd);
						}
					}
					inner += "},\n";
					res+=inner;
				}
				
			}
		}
		System.out.println(res);
		
	}
}
