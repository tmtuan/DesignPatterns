class MakeACaptain
{
    private static MakeACaptain _captain;

    // private constructor to prevent the use of 'new'
    private MakeACaptain() { }

    // Method to provide only one instance of the class
    public static MakeACaptain getCaptain()
    {
        // Lazy initialization
        if (_captain == null)
        {
            _captain = new MakeACaptain();
            System.out.println("New Captain selected for our eam");
        }
        else 
        {
            System.out.println("You already have a Captain");
            System.out.println("Send him for a toss");
        }
        return _captain;
    }
}

class SingletonPatternExample
{
    public static void main(String[] args)
    {
        System.out.println("***Singleton Pattern Demo ***\n");
        System.out.println("Trying to make a captain for our team");
        MakeACaptain c1 = MakeACaptain.getCaptain();
        System.out.println("Trying to make another captain for our team");
        MakeACaptain c2 = MakeACaptain.getCaptain();
        if (c1 == c2)
        {
            System.out.println("c1 and c2 are the same instance");
        }
    }
}