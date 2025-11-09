package Interface;

public interface Editable<T> {
    void edit(T updatedData);

    boolean validate();
}
