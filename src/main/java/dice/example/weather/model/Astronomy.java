package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astronomy{
    public Date dawn;
    public Date sunrise;
    public Date suntransit;
    public Date sunset;
    public Date dusk;
    public Date moonrise;
    public Date moontransit;
    public Date moonset;
    public int moonphase;
    public int moonzodiac;
}
