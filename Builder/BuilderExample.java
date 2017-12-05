import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.LinkedList;

import oracle.jrockit.jfr.ProducerDescriptor;
import oracle.jrockit.jfr.events.EventDescriptor;

// Builders common interface
interface IBuilder
{
    void BuildBody();
    void InsertWheels();
    void AddHeadLights();
    Product GetVehicle();
}

// Car is ConcreteBuilder
class Car implements IBuilder
{
    private Product product = new Product();

    @Override
    public void BuildBody()
    {
        product.Add("This is a body of a Car");
    }

    @Override
    public void InsertWheels()
    {
        product.Add("4 wheels are added");
    }

    @Override
    public void AddHeadLights()
    {
        product.Add("2 Headlights are added");
    }

    @Override
    public Product GetVehicle()
    {
        return product;
    }
}

// Motocycle is a ConcreteBuilder
class Motorcycle implements IBuilder
{
    private Product product = new Product();

    @Override
    public void BuildBody()
    {
        product.Add("This is a body of Motocycle");
    }

    @Override
    public void InsertWheels()
    {
        product.Add("2 wheels are added");
    }

    @Override
    public void AddHeadLights()
    {
        product.Add("1 Headlight is added");
    }

    @Override
    public Product GetVehicle()
    {
        return product;
    }
}

// Product
class Product
{
    private LinkedList<String> parts;
    public Product()
    {
        parts  = new LinkedList<String>();
    }
    public void Add(String part)
    {
        // Adding parts
        parts.addLast(part);
    }
    public void Show()
    {
        System.out.println("\n Product complete as below: ");
        for(int i = 0; i < parts.size(); i++)
        {
            System.out.println(parts.get(i));
        }
    }
}

// Director
class Director
{
    IBuilder myBuilder;

    // A series of steps for the production
    public void Construct(IBuilder builder)
    {
        myBuilder = builder;
        myBuilder.BuildBody();
        myBuilder.InsertWheels();
        myBuilder.AddHeadLights();
    }
}

class BuilderPatternExample
{
    public static void main(String[] args)
    {
        System.out.println("*** Build Pattern Demo***\n");

        Director director = new Director();
        IBuilder carBuilder= new Car();
        IBuilder motorBuilder = new Motorcycle();

        // Making Car
        director.Construct(carBuilder);
        Product p1 = carBuilder.GetVehicle();
        p1.Show();

        // Making Motorcycle
        director.Construct(motorBuilder);
        Product p2 = motorBuilder.GetVehicle();
        p2.Show();
    }
}