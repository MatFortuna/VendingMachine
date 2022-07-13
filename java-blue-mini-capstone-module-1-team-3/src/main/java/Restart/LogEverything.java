package Restart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class LogEverything {

// no method to call
    File log = new File("log.txt");
    String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm:ss a"));
    {

        if (!log.exists()){
            try {
                log.createNewFile();
                try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                    pw.println(dateTime + "" +"" );
                } catch (IOException e) {

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {  try (PrintWriter pw = new PrintWriter(new FileWriter(log, true))) {
                    pw.println(dateTime + "" + "" );

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }


    }



}
