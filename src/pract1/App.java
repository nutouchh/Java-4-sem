package pract1;

import java.util.function.Consumer;
public class App implements Consumer<String>{

    @Override
    public void accept(String st) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < st.length(); i++){
            if ((i + 1) % 3 == 0){
                s.append(st.substring(i,i+1).toUpperCase());
            }
            else s.append(st.charAt(i));
        }
        System.out.println(s);

    }

    @Override
    public Consumer andThen(Consumer after) {
        return Consumer.super.andThen(after);
    }

    public static void main(String[] args) {
        App st = new App();
        st.accept("asdfghjklpoiu");
    }

}
