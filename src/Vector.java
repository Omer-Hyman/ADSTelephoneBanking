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

    public void append(UserRecord value)
    {
        if (length == array.length) {
            UserRecord[] longerArray = new UserRecord[array.length/5 + array.length ];
            for (int i = 0; i < array.length;i++)
                longerArray[i] = array[i];
            array = longerArray;
        }
        array[length++] = value;
    }

    public UserRecord[] getArray() {
        return array;
    }

    public void mergeSort(UserRecord[] array, int arrayLength)
    {
        if (arrayLength < 2)
        {
            return;
        }
        int mid = arrayLength/2;
        UserRecord[] leftArray = new UserRecord[mid];
        UserRecord[] rightArray = new UserRecord[arrayLength-mid];

        for (int i = 0; i < mid; i++)
        {
            leftArray[i] = array[i];
        }

        for (int i = mid; i < arrayLength; i++)
        {
            rightArray[i-mid] = array[i];
        }

        mergeSort(leftArray, mid);
        mergeSort(rightArray, arrayLength - mid);
        merge(array, leftArray, rightArray, mid, arrayLength - mid);

    }

    public static void merge(UserRecord[] array, UserRecord[] leftArray, UserRecord[] rightArray, int left, int right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
        {
            if (leftArray[i].getUserName().compareTo(rightArray[j].getUserName()) < 0)
            {
                array[k++] = leftArray[i++];
            }
            else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left){
            array[k++] = leftArray[i++];
        }
        while (j < right)
        {
            array[k++] = rightArray[j++];
        }
    }








}
