import ReverseModule.*;

public class ReverseImpl extends ReversePOA {
    public String doReverse(String a)
    {
        StringBuffer stringBuffer = new StringBuffer(a);
        return stringBuffer.reverse().toString();
    }
}