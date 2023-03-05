package pract6.Prototype;

import java.util.HashMap;
import java.util.Map;

public class PencilStore {
    private static Map<String, Pencil> colorMap = new HashMap<String, Pencil>();

    static
    {
        colorMap.put("blue", new BluePencil());
        colorMap.put("yellow", new YellowPencil());
    }

    public static Pencil getPencil(String colorName)
    {
        return (Pencil) colorMap.get(colorName).clone();
    }
}