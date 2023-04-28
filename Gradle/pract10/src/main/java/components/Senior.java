package components;

import interfaces.Programmer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("Senior")
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior java developer writing code...");
    }
}