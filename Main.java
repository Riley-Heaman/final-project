//Riley Heaman
//CIS 219: Mr. Swinarski
//Final Project - Happy Birthday? Message & Age
//**DATE**

//Relevant Libraries
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
public class Main {
    /* PSEUDO-CODE
    -yourBirthday?
    -today'sDate?
    -age?
    -message */
    //Variables
    public static void main(String args[]){
        //Lets begin.
        Scanner get = new Scanner(System.in);
        LocalDate theirBDay = getBirthDay(get);
        while(true){
            if (theirBDay != null){
                break;
            }
            theirBDay = getBirthDay(get);
        }
        get.close();
        getAge(theirBDay);
        getHoroscope(theirBDay);

    }

    static void getAge(LocalDate birth){
        //calculate and report the age and if it is their birthday today.
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birth.getYear();
        System.out.println("Today is: " + today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("You were born on: " + birth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        if ((today.getDayOfMonth() == birth.getDayOfMonth()) && (today.getMonth() == birth.getMonth())){
            System.out.println("Today is your birthday! Happy Birthday :)");
        }
        if ((today.getDayOfMonth() < birth.getDayOfMonth()) && (today.getMonthValue() == birth.getMonthValue())){
            System.out.println("That makes you " + (age-1) + " years old.");
        }
        else{
            System.out.println("That makes you " + age + " years old.");
        }
    }

    static LocalDate getBirthDay(Scanner input){
        //This function will get the correct format birthday from the user.
        System.out.println("Please enter your birthday for a special message: (mm/dd/yyyy) or (mm-dd-yyyy).");
        String dateOfBirth;
        Boolean correct = false;
        input.useDelimiter(System.lineSeparator());
        LocalDate birthday = null;
        while(correct != true){
            dateOfBirth = input.next();

            //Make sure input is the correct length
            if (dateOfBirth.length() == 10){
                //If both characters between numbers are not the same and aren't ('/' | '-') re-promt and try again.
                if ((dateOfBirth.charAt(2) != '/' && dateOfBirth.charAt(2) != '-') 
                 && (dateOfBirth.charAt(5) != '/' && dateOfBirth.charAt(5) != '-')){
                    System.out.println("Please use the format (mm/dd/yyyy) or (mm-dd-yyyy):");
                }

                //If both characters between numbers are the same and ('/' | '-') then it is correct.
                else if ((dateOfBirth.charAt(2) == '/' && dateOfBirth.charAt(5) == '/') 
                      || (dateOfBirth.charAt(2) == '-' && dateOfBirth.charAt(5) == '-')){

                    //convert the year section into an int of the same value
                    int year = ((Character.getNumericValue(dateOfBirth.charAt(6)) * 1000) +
                                (Character.getNumericValue(dateOfBirth.charAt(7)) * 100) +
                                (Character.getNumericValue(dateOfBirth.charAt(8)) * 10) +
                                 Character.getNumericValue(dateOfBirth.charAt(9)));
                    //convert the string of the "month" to int then to the data type Month
                    Month month;
                    if (dateOfBirth.charAt(0) == '0'){
                        int monthNum = (Character.getNumericValue(dateOfBirth.charAt(1)));
                        try{
                            month = Month.of(monthNum);
                            //convert the day section into an int of the same value
                            int dayOfMonth = ((Character.getNumericValue(dateOfBirth.charAt(3)) * 10) +
                                               Character.getNumericValue(dateOfBirth.charAt(4)));
                            
                            //update the LocalDate "birthday" to reflect the input. Only works for a real date.
                            try{
                                birthday = LocalDate.of(year, month, dayOfMonth);
                                correct = true;
                            }
                            catch(Exception e){
                                System.out.println("Please use a valid date.");
                            }
                            finally{}}
                            
                        catch(Exception e){
                            System.out.println("Please use a valid date.");
                        }

                        if (birthday != null){
                            correct = true;
                            break;
                        }
                        else{
                            break;
                        } 
                    }
                    else{
                        int monthNum = ((Character.getNumericValue(dateOfBirth.charAt(0)) * 10) +
                                         Character.getNumericValue(dateOfBirth.charAt(1)));
                        try{
                            month = Month.of(monthNum);
                            //convert the day section into an int of the same value
                            int dayOfMonth = ((Character.getNumericValue(dateOfBirth.charAt(3)) * 10) +
                                               Character.getNumericValue(dateOfBirth.charAt(4)));
                            
                            //update the LocalDate "birthday" to reflect the input. Only works for a real date.
                            try{
                                birthday = LocalDate.of(year, month, dayOfMonth);
                                correct = true;
                            }
                            catch(Exception e){
                                System.out.println("Please use a valid date.");

                            }
                            finally {}}
                        catch(Exception e){
                            System.out.println("Please use a valid date.");
                        }

                        if (birthday != null){
                            correct = true;
                            break;
                        }
                        else{
                            break;
                        } 
                    }     
                }
                //Error catch for: mismatched '/' or '-'
                else{
                    System.out.println("Please use the format (mm/dd/yyyy) or (mm-dd-yyyy):");
                }
            }
            //Error catch for: incorrect length
            else{
                System.out.println("Please use the format (mm/dd/yyyy) or (mm-dd-yyyy):");
            }
        }
        return birthday; 
    }
}   


