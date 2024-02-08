package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avg{
    public String description;
    public String format;
    public double maximum;
    public double minimum;
    public ArrayList<String> type;
}
