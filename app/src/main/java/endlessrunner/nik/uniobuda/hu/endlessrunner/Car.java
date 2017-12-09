package endlessrunner.nik.uniobuda.hu.endlessrunner;

;

public abstract class Car {
    public int getLine() {
        return columnPosition;
    }

    public void setLine(byte columnPosition) {
        this.columnPosition = columnPosition;
    }



    public void setY(int y) {
        this.y = y;
    }

    int y;

    public int getY() {
        return y;
    }

    int columnPosition;





    public Car(int line) {
        this.columnPosition = line;
    }
}
