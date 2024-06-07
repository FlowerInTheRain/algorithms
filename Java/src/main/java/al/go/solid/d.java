package al.go.solid;

public class d {
    private interface Logger {

        void log(String message);
    }

    private class ConsoleLogger implements Logger {
        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }

    private class LoggerService {
        private final Logger logger;

        public LoggerService(Logger logger) {
            this.logger = logger;
        }
        public void log(String message) {
            logger.log(message);
        }
    }

    private interface Shape {
        Double area();
    }

    private class Rectangle implements Shape {
        Double width;
        Double height;

        public Rectangle(Double width, Double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public Double area() {
            return width * height;
        }
    }

    private class Circle implements Shape {
        Integer radius;

        public Circle(Integer radius) {
            this.radius = radius;
        }

        @Override
        public Double area() {
            return Math.PI * Math.pow(radius,2);
        }
    }

    private class Geometry {
        Double area(Shape shape){
            return shape.area();
        }
    }
}