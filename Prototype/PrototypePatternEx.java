import java.util.Random;

abstract class BasicCar implements Cloneable
{
    public String modelname;
    public int price;

    public String getModelname()
    {
        return modelname;
    }

    public void setModelname(String _modelname)
    {
        this.modelname = _modelname;
    }

    public static int setPrice()
    {
        int price = 0;
        Random r = new Random();
        int p = r.nextInt(100000);
        price = p;
        return price;
    }

    public BasicCar clone() throws CloneNotSupportedException
    {
        return (BasicCar)super.clone();
    }
}

class Ford extends BasicCar
{
    public Ford(String m)
    {
        modelname = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException
    {
        return (Ford)super.clone();
    }
}

class Nano extends BasicCar
{
    public Nano(String m)
    {
        modelname = m;
    }

    @Override
    public BasicCar clone() throws CloneNotSupportedException
    {
        return (Nano)super.clone();
    }
}

class PrototypePatternEx
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        System.out.println("*** Prototype Pattern Demo ***\n");
        BasicCar nano_base = new Nano("Green Nano");
        nano_base.price = 100000;

        BasicCar ford_basic = new Ford("Ford Yellow");
        ford_basic.price = 500000;

        BasicCar bc1;
        //Clone Nano Object
        bc1 = nano_base.clone();
        //Price  will be more than 100000
        bc1.price = ford_basic.price + BasicCar.setPrice();
        System.out.println("Car is: " + bc1.modelname+ " and it's price is " + bc1.price);

        //Clone Ford Object
        bc1 = ford_basic.clone();
        //Price  will be more than 100000
        bc1.price = nano_base.price + BasicCar.setPrice();
        System.out.println("Car is: " + bc1.modelname+ " and it's price is " + bc1.price);


    }
}