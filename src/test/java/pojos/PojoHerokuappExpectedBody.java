package pojos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PojoHerokuappExpectedBody {
    /*
      {
         "bookingid":24,
         "booking":{
             "firstname":"Ahmet",
             "lastname":"Bulut",
             "totalprice":500,
             "depositpaid":false,
             "bookingdates":{
                 "checkin":"2021-06-01",
                 "checkout":"2021-06-10"
                             }
             ,
             "additionalneeds":"wi-fi"
                   }
        }
        -Bu kalibi bir kere olusturuyorsun, sonra bin defa test yapabilirsin. Surekli ayni url uzerinden calisacagimiz icin.
     */
    private int bookingid;
    private PojoHerokuappBooking booking;
}