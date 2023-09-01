package be.technifutur.spring.demo.exceptions;

public class CapacityExceededException extends RuntimeException{
    private final Object id;
    private final Class<?> resourceClass;

    public CapacityExceededException(Object id, Class<?> resourceClass) {
        super("There is already too much player in this {%s} with id {%s}".formatted(resourceClass.getSimpleName(), id.toString()));
        this.id = id;
        this.resourceClass = resourceClass;
    }
}
