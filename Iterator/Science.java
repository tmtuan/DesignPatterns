package aggregate;
//for Linked List data structure used here
import java.util.LinkedList;

import aggregate.ISubject;
import iterator.*;

class Science implements ISubject
{
    private LinkedList<String> subjects;

    public Science()
    {
        subjects = new LinkedList<String>(); 
        subjects.addLast("Maths"); 
        subjects.addLast("Comp. Sc."); 
        subjects.addLast("Physics");
    }

    @Override
    public IIterator CreateIIterator(LinkedList<String> subjects)
    {
        this.subjects = subjects;
        position = 0;
    }

    public void First()
    {
        position = 0;
    }

    public String Next()
    {
        
    }
}