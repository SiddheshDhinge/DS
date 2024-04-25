import ChangeCaseModule.*;

public class ChangeCaseImpl extends ChangeCasePOA {
    public String update(String a) {
        StringBuffer str = new StringBuffer(a);
        for(int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z')
                str.setCharAt(i, (char) (c - 'A' + 'a'));
            else if(c <= 'z' && c >= 'a')
                str.setCharAt(i, (char) (c - 'a' + 'A'));
        }
        return str.toString();
    }
}