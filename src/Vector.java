public class Vector {
    private UserRecord[] array;
    private int length;

    Vector(){
        array = new UserRecord[100];
        length = 0;
    }

    Vector(int c)
    {
        length = 0;
        array = new UserRecord[c];
    }

    public int getLength() {
        return length;
    }

    public void incrementLength()
    {
        length++;
    }

    public void decrementLength()
    {
        length--;
    }

    public void append(UserRecord value)
    {
        if (length == array.length) {
            UserRecord[] longerArray = new UserRecord[array.length/2 + array.length ];
            for (int i = 0; i < array.length;i++)
                longerArray[i] = array[i];
            array = longerArray;
        }
        array[length++] = value;
    }

    public UserRecord[] getArray() {
        return array;
    }
}
