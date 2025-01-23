package TestSingleton;

public class B {

    private int x;

  private static B b;
    private B(){
        System.out.println("je suis B");
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static B getInstance(){
        if(b == null){
            b=new B();
        }
        return b;
    }
}
