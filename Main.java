//Riley Heaman
//CIS 219: Mr. Swinarski
//Final Project - Happy Birthday? Message & Age
//12/22/2021

//Relevant Libraries
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
public class Main {
    public static void main(String args[]){
        //Lets begin. Open the scanner.
        Scanner get = new Scanner(System.in);

        //Get their birthday.
        LocalDate theirBDay = getBirthDay(get);

        //Make sure its correct.
        while(true){
            if (theirBDay != null){
                break;
            }
            theirBDay = getBirthDay(get);
        }

        //We are done with the scanner.
        get.close();

        //Calculate the age.
        int numOfYears = getAge(theirBDay);

        //Determine their horoscope sign.
        String sign = getHoroscope(theirBDay);

        //Display their message.
        System.out.println("As a " + numOfYears + " year old " + sign + ", here is your message:\n\n" + getMessage(sign));
        System.out.println("\nI, Riley Heaman, do not take credit for these horoscope preditions.\n" +
        "They were borrowed from \"https://www.allure.com/story/zodiac-sign-personality-traits-dates\", &\n" +
        "Written by: Aliza Kelly On: November 10th, 2021\n");
    }

    static String getMessage(String horoscope){
        //create a hashmap with [key,value] pairs.
        HashMap<String, String> message = new HashMap<String, String>();

        //Load our HashMap with data.
        message.put("Aries", "The first sign of the zodiac, Aries loves to be number one.\n" + 
                    "Naturally, this dynamic fire sign is no stranger to competition.\n" + 
                    "Bold and ambitious, Aries dives headfirst into even the most challenging situations—and they'll make sure they always come out on top!");
        message.put("Taurus", "What sign is more likely to take a six-hour bath, followed by a luxurious Swedish massage and decadent dessert spread?\n" + 
                    "Why Taurus, of course!\n" + 
                    "Taurus is an earth sign represented by the bull.\n" + 
                    "Like their celestial spirit animal, Taureans enjoy relaxing in serene, bucolic environments surrounded by soft sounds, soothing aromas, and succulent flavors.");
        message.put("Gemini", "Have you ever been so busy that you wished you could clone yourself just to get everything done?\n" +
                    "That's the Gemini experience in a nutshell.\n" + "Spontaneous, playful, and adorably erratic, Gemini is driven by its insatiable curiosity.\n" +
                    "Appropriately symbolized by the celestial twins, this air sign was interested in so many pursuits that it had to double itself.\n" +
                    "You know, NBD!");
        message.put("Cancer", "Represented by the crab,\n" +
                    "Cancer seamlessly weaves between the sea and shore representing Cancer\'s ability to exist in both emotional and material realms.\n" +
                    "Cancers are highly intuitive and their psychic abilities manifest in tangible spaces.\n" +
                    "But—just like the hard-shelled crustaceans—this water sign is willing to do whatever it takes to protect itself emotionally.\n" +
                    "In order to get to know this sign, you're going to need to establish trust!");
        message.put("Leo", "Roll out the red carpet because Leo has arrived.\n" +
                    "Passionate, loyal, and infamously dramatic, Leo is represented by the lion and these spirited fire signs are the kings and queens of the celestial jungle.\n" +
                    "They're delighted to embrace their royal status: Vivacious, theatrical, and fiery, Leos love to bask in the spotlight and celebrate… well, themselves.");
        message.put("Virgo", "You know the expression, \"if you want something done, give it to a busy person?\".\n" +
                    "Well, that definitely is the Virgo anthem.\n" +
                    "Virgos are logical, practical, and systematic in their approach to life.\n" +
                    "Virgo is an earth sign historically represented by the goddess of wheat and agriculture, an association that speaks to Virgo's deep-rooted presence in the material world.\n" +
                    "This earth sign is a perfectionist at heart and isn\'t afraid to improve skills through diligent and consistent practice.");
        message.put("Libra", "Balance, harmony, and justice define Libra energy.\n" +
                    "As a cardinal air sign, Libra is represented by the scales (interestingly, the only inanimate object of the zodiac), an association that reflects Libra's fixation on establishing equilibrium.\n" +
                    "Libra is obsessed with symmetry and strives to create equilibrium in all areas of life — especially when it comes to matters of the heart.");
        message.put("Scorpio", "Elusive and mysterious, Scorpio is one of the most misunderstood signs of the zodiac.\n" +
                    "Scorpio is a water sign that uses emotional energy as fuel, cultivating powerful wisdom through both the physical and unseen realms.\n" +
                    "In fact, Scorpio derives its extraordinary courage from its psychic abilities, which is what makes this sign one of the most complicated, dynamic signs of the zodiac.");
        message.put("Sagittarius", "Oh, the places Sagittarius goes!\n" +
                    "But… actually.\n" +
                    "This fire sign knows no bounds.\n" +
                    "Represented by the archer, Sagittarians are always on a quest for knowledge.\n" +
                    "The last fire sign of the zodiac, Sagittarius launches its many pursuits like blazing arrows, chasing after geographical, intellectual, and spiritual adventures.");
        message.put("Capricorn", "What is the most valuable resource?\n" +
                    "For Capricorn, the answer is clear: Time.\n" +
                    "Capricorn is climbing the mountain straight to the top and knows that patience, perseverance, and dedication is the only way to scale.\n" +
                    "The last earth sign of the zodiac, Capricorn, is represented by the sea-goat, a mythological creature with the body of a goat and the tail of a fish.\n" +
                    "Accordingly, Capricorns are skilled at navigating both the material and emotional realms.");
        message.put("Aquarius", "Despite the \"aqua\" in its name, Aquarius is actually the last air sign of the zodiac.\n" +
                    "Innovative, progressive, and shamelessly revolutionary, Aquarius is represented by the water bearer, the mystical healer who bestows water, or life, upon the land.\n" +
                    "Accordingly, Aquarius is the most humanitarian astrological sign.\n" +
                    "At the end of the day, Aquarius is dedicated to making the world a better place.");
        message.put("Pisces", "If you looked up the word \"psychic\" in the dictionary, there would definitely be a picture of Pisces next to it.\n" +
                    "Pisces is the most intuitive, sensitive, and empathetic sign of the entire zodiac -- and that\'s because it\'s the last of the last.\n" +
                    "As the final sign, Pisces has absorbed every lesson -- the joys and the pain, the hopes and the fears -- learned by all of the other signs.\n" +
                    "It's symbolized by two fish swimming in opposite directions, representing the constant division of Pisces' attention between fantasy and reality.");
        //String result = message.get(horoscope);
        return message.get(horoscope);
    }

    static String getHoroscope(LocalDate date){
        String sign = null;
        int month = date.getMonthValue();
        int bday = date.getDayOfMonth();

        //Which sign do you belong to?
        switch (month){
            case 1:
                if (bday < 20){
                    sign = "Capricorn";
                    break;  
                }
                else{
                    sign = "Aquarius";
                    break;
                }
            case 2:
                if (bday < 19){
                    sign = "Aquarius";
                    break;  
                }
                else{
                    sign = "Pisces";
                    break;
                }
            case 3:
                if (bday < 21){
                    sign = "Pisces";
                    break;  
                }
                else{
                    sign = "Aries";
                    break;
                }
            case 4:
                if (bday < 20){
                    sign = "Aries";
                    break;  
                }   
                else{
                    sign = "Taurus";
                    break;
                }
            case 5:
                if (bday < 21){
                    sign = "Taurus";
                    break;  
                }
                else{
                    sign = "Gemini";
                    break;
                }
            case 6:
                if (bday < 21){
                    sign = "Gemini";
                break;  
                }
                else{
                sign = "Cancer";
                    break;
                }
            case 7:
                if (bday < 23){
                    sign = "Cancer";
                    break;  
                }
                else{
                    sign = "Leo";
                    break;
                }
            case 8:
                if (bday < 23){
                    sign = "Leo";
                    break;  
                }
                else{
                    sign = "Virgo";
                    break;
                }
            case 9:
                if (bday < 23){
                    sign = "Virgo";
                    break;  
                }
                else{
                    sign = "Libra";
                    break;
                }
            case 10:
                if (bday < 23){
                    sign = "Libra";
                    break;  
                }
                else{
                    sign = "Scorpio";
                    break;
                }
            case 11:
                if (bday < 22){
                    sign = "Scorpio";
                    break;  
                }
                else{
                    sign = "Sagittarius";
                    break;
                }
            case 12:
                if (bday < 22){
                sign = "Sagittarius";
                    break;  
                }
                else{
                    sign = "Capricorn";
                break;
            }
        }
        return sign;
    }

    static int getAge(LocalDate birth){
        //calculate and report the age and if it is their birthday today.
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birth.getYear();
        System.out.println("\nToday is: " + today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println("You were born on: " + birth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));

        //Its your birthday!
        if ((today.getDayOfMonth() == birth.getDayOfMonth()) && (today.getMonth() == birth.getMonth())){
            System.out.println("Today is your birthday! Happy Birthday :)");
        }
        //if your birthday hasn't passed yet this year.
        if ((today.getDayOfMonth() < birth.getDayOfMonth()) && (today.getMonthValue() == birth.getMonthValue())){
            System.out.println("That makes you " + (age-1) + " years old.");
            return age-1;
        }
        else{
            System.out.println("That makes you " + age + " years old.");
            return age;
        }
    }

    static LocalDate getBirthDay(Scanner input){
        //This function will get the correct format birthday from the user.
        System.out.println("Please enter your birthday and I'll tell you what your horoscope sign is & who they tend to be.\n" +
                           "(mm/dd/yyyy) or (mm-dd-yyyy)");
        String dateOfBirth;
        input.useDelimiter(System.lineSeparator());
        LocalDate birthday = null;
        dateOfBirth = input.next();

        //Make sure input is the correct length
        if (dateOfBirth.length() == 10){
                
            //If both characters between numbers are the same and ('/' | '-') then it is correct.
            if ((dateOfBirth.charAt(2) == '/' && dateOfBirth.charAt(5) == '/') 
             || (dateOfBirth.charAt(2) == '-' && dateOfBirth.charAt(5) == '-')){

                //convert the year section into an int of the same value
                int year = ((Character.getNumericValue(dateOfBirth.charAt(6)) * 1000) +
                            (Character.getNumericValue(dateOfBirth.charAt(7)) * 100) +
                            (Character.getNumericValue(dateOfBirth.charAt(8)) * 10) +
                             Character.getNumericValue(dateOfBirth.charAt(9)));
                try{
                    Boolean yearChk = null;
                    if (year < 2022 && year > 1910){
                        yearChk = true;
                    }
                    yearChk.equals(true);
                }
                catch(Exception e){
                    System.out.println("Please use a valid date.\n");
                    return null;
                }
                //convert the string of the "month" to int then to the data type Month
                Month month;
                int monthNum;
                //if the first digit is 0 start here.
                if (dateOfBirth.charAt(0) == '0'){
                    monthNum = (Character.getNumericValue(dateOfBirth.charAt(1)));
                }
                else{
                    monthNum = ((Character.getNumericValue(dateOfBirth.charAt(0)) * 10) +
                                 Character.getNumericValue(dateOfBirth.charAt(1)));
                }
                try{
                    //Check if the month is correct.
                    month = Month.of(monthNum);
                    //convert the day section into an int of the same value
                    int dayOfMonth = ((Character.getNumericValue(dateOfBirth.charAt(3)) * 10) +
                                       Character.getNumericValue(dateOfBirth.charAt(4)));
                            
                    //update the LocalDate "birthday" to reflect the input. Only works for a real date.
                    try{
                        birthday = LocalDate.of(year, month, dayOfMonth);
                    }

                    //date is incorrect
                    catch(Exception e){
                        System.out.println("Please use a valid date.\n");
                    }
                    finally{}}
                //incorrect month    
                catch(Exception e){
                    System.out.println("Please use a valid date.\n");
                }
            }
            //Error catch for: mismatched '/' or '-'
            else{
                System.out.println("Please use the format (mm/dd/yyyy) or (mm-dd-yyyy)\n");
            }
        }
        //Error catch for: incorrect length
        else{
            System.out.println("Please use the format (mm/dd/yyyy) or (mm-dd-yyyy)\n");
        }
        return birthday; 
    }
}   