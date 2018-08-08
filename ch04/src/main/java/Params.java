class ParamVar {
    private double var = 0;

    public ParamVar(double aVar) {
        var = aVar;
    }

    public double getVar() {
        return var;
    }

    public void setVar(double aVar) {
        var = aVar;
    }
}

public class Params {

    public static void swap(double x, double y) {
        double tmp = x;
        x = y;
        y = tmp;
        System.out.println("swap, x = " + x + ", y = " + y);
    }

    public static void swap(ParamVar x, ParamVar y) {
        ParamVar tmp = x;
        x = y;
        y = tmp;
        System.out.println("swap, xVar = " + x.getVar() + ", y = " + y.getVar());
    }

    public static void change(ParamVar z) {
        z.setVar(-1);

        System.out.println("change, zVar = " + z.getVar());
    }

    public static void main(String[] args) {
        double x = 1;
        double y = 2;
        System.out.println("before swap, x = " + x + ", y = " + y);
        swap(x, y);
        System.out.println("after swap, x = " + x + ", y = " + y);

        ParamVar xVar = new ParamVar(1);
        ParamVar yVar = new ParamVar(2);

        System.out.println("before swap, xVar = " + xVar.getVar() + ", yVar = " + yVar.getVar());
        swap(xVar, yVar);
        System.out.println("after swap, xVar = " + xVar.getVar() + ", yVar = " + yVar.getVar());

        ParamVar zVar = new ParamVar(3);


        System.out.println("before change, zVar = " + zVar.getVar());
        change(zVar);
        System.out.println("before change, zVar = " + zVar.getVar());

    }
}