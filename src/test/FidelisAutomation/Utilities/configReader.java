package FidelisAutomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class configReader
{
    Properties pro;
    public configReader()
    {
        File src = new File("./Configuration/config.property");
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(src);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        pro = new Properties();
        try
        {
            pro.load(fis);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getUrl()
    {
        String URL = pro.getProperty("URL");
        return URL;
    }

    public String getAdminID()
    {
        String adminID = pro.getProperty("adminId");
        return adminID;
    }
    public String getPassword()
    {
        String password = pro.getProperty("password");
        return password;
    }
    public String getBrowserName()
    {
        String browserName = pro.getProperty("browserName");
        return browserName;
    }

    public String getStudentID()
    {
        String studentId = pro.getProperty("studentId");
        return studentId;
    }
    public String getCoachID()
    {
        String coachId = pro.getProperty("coachId");
        return coachId;
    }

    public String getAuthorID()
    {
        String authorId = pro.getProperty("authorId");
        return authorId;
    }

    public String getPublisherID()
    {
        String publisherId = pro.getProperty("publisherId");
        return publisherId;
    }
    public String getModeratorId()
    {
        String moderatorId = pro.getProperty("moderatorId");
        return moderatorId;
    }
}
