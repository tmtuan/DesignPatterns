import javax.swing.Icon;

interface ICommand
{
    void Do();
}

class MyUndoCommand implements ICommand 
{
    private Receiver receiver;

    MyUndoCommand(Receiver recv)
    {
        receiver = recv;
    }

    @Override
    public void Do()
    {
        //Call undo in receiver
        receiver.performUndo();
    }
}

class MyRedoCommand implements ICommand
{
    private Receiver receiver;

    MyRedoCommand(Receiver recv)
    {
        receiver = recv;
    }

    @Override
    public void Do()
    {
        //Call undo in receiver
        receiver.performRedo();
    }
}

// Receiver class
class Receiver
{
    public void performUndo()
    {
        System.out.println("Executing Undo Command");
    }

    public void performRedo()
    {
        System.out.println("Executing Redo Commnad");
    }
}

// Invoke class
class Invoke
{
    ICommand cmd;
    public void ExecuteCommand(ICommand cmd)
    {
        this.cmd = cmd;
        cmd.Do();
    }
}

// Client Class
class CommandPatternEx
{
    public static void main(String[] args)
    {   
        System.out.println("*** Command Pattern Example ***\n");
        Receiver intendedreceiver = new Receiver();

        /* Client holds invoker and command objects */
        Invoke inv = new Invoke();
        MyUndoCommand unCmd = new MyUndoCommand(intendedreceiver);
        MyRedoCommand reCmd = new MyRedoCommand(intendedreceiver);
        inv.ExecuteCommand(unCmd);
        inv.ExecuteCommand(reCmd);
    }
}