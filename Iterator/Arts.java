package aggregate; 
import aggregate.ISubject;
import iterator.*;

class Arts implements ISubject
{
    private String[] subjects;

    public Arts()
    {
        subjects = new String[2];
        subjects[0] = "English";
        subjects[1] = "Math";
    }

    @Override
    public IIterator CreatIterator()
    {
        return new ArtsIterator(subjects);
    }

    class ArtsIterator implements IIterator 
    {
        private String[] subjects;
        private int position;
        public ArtsIterator(String[] subjects)
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
            return subjects[position++];
        }
        public Boolean IsDone()
        {
            return postion >= subjects.length;
        } 
        public String CurrentItem()
        {
            return subjects[position];
        }
    }
}