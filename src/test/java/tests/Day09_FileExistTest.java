package tests;

import org.junit.Test;

public class Day09_FileExistTest {
    @Test
    public void isExistTest(){

        String userDIR= System.getProperty("user.dir");       //=>gives the path of the current project folder
        System.out.println(userDIR); ///Users/techproed/IdeaProjects/SeleniumNewProject


        String userHOME=System.getProperty("user.home");      //=>gives you the user folder
        System.out.println(userHOME); ///Users/techproed


//        Pick a file on your desktop
//        And verify if that file exist on your computer or not

        String pathOfFile = userHOME + "/Desktop"

    }
}
