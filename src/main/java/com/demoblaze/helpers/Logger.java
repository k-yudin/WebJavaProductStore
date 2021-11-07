package com.demoblaze.helpers;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public static void addOrderDetails(String orderID, String orderPriceAmount) {
        try
        {
            String filename= "orders.log";
            FileWriter fw = new FileWriter(filename, true);
            fw.write(String.format("Oder ID: %1$s Order Total Price: %2$s USD", orderID, orderPriceAmount));
            fw.write("\n------------------------------------------------\n");
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("There was a problem writing to the log file: " + ioe.getMessage());
        }
    }
}
