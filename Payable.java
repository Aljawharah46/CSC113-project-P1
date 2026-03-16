public interface Payable {

    long id = 0;
    long CLASS_ATTRIBUTE = 0;

    int operation(int value);

    void abstractOperation();
}
