package endlessrunner.nik.uniobuda.hu.endlessrunner;

;

public abstract class Car {
    public byte getColumnPosition() {
        return columnPosition;
    }

    public void setColumnPosition(byte columnPosition) {
        this.columnPosition = columnPosition;
    }

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    byte columnPosition;

    Color clr;



    public Car(byte clm,  Color clr) {
        this.columnPosition = clm;
        this.clr = clr;
    }
}
