package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wind{
    public String unit;
    public String direction;
    public String text;
    public Object avg;
    public int min;
    public int max;
    public Gusts gusts;
    public boolean significationWind;
}
