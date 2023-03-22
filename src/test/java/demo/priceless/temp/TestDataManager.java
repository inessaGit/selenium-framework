package demo.priceless.temp;

import demo.priceless.utils.ConfigurationManager;
import demo.priceless.utils.DataManager;

class TestDataManager{
    public static void main (String[] args){

        String env = ConfigurationManager.getInstance().getProperty("env");//reading from config.properties
        System.out.println(env);
        String userEmail = DataManager.getInstance().getString("user_email");
        System.out.println(userEmail);
    }
}