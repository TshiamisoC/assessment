
package seriesapp;

import java.util.*;

public class SeriesApp {

    
    public static void main(String[] args) {
        
        
        ArrayList<Series> seriesList = new ArrayList<>();// array list to store all series added
        
        
        Scanner option = new Scanner(System.in);
        
        //prompting user for input
        System.out.println("Eneter l to launch menu or any other key to exit");
        
        String input = option.nextLine().toLowerCase();
        
        while("l".equals(input)){
            
            
            Scanner optionInput = new Scanner(System.in);
            String optionChosen;
            //validating user input to ensure correct options are used.
            while (true)
            {
                System.out.println("""
                               Please select one of the following menu items:
                               (1) Capture a new series
                               (2) Search for a series
                               (3) Update series age restriction
                               (4) Delete a series
                               (5) Print series report
                               (6) Exit Application
                               """);
                optionChosen = optionInput.nextLine();

                if (optionChosen.equals("1") ||
                    optionChosen.equals("2") ||
                    optionChosen.equals("3") ||
                    optionChosen.equals("4") ||
                    optionChosen.equals("5") ||
                    optionChosen.equals("6")) {
                    break; 
                }

            System.out.println("Invalid input. Please enter a number between 1 and 6 only.");
            }

       
            
                if(!"6".equals(optionChosen)){
                    
                    //switch case will run the different valid inputs of the given options
                    switch(optionChosen){   
                        
                        case "1": 
                            //this method will capture a new series
                            CaptureSeries(seriesList);
                            
                            break;
                        case "2":
                            
                            //calling the search method and passing the array list
                            SearchSeries(seriesList);
                            
                            break;
                        case "3":
                            //call to the update method and passing the array list
                            update(seriesList);
                            break;
                        case "4": 
                            //call to the delete method
                            deleteSeries(seriesList);
                            break;
                        case "5":
                            //call to the printReport method
                            printReport(seriesList);
                            break;
                        default:
                            break;
                       
                    }
                    
                    
                }
            
             //reprompting user to change the loop control variable
            System.out.println("Eneter l to launch menu or any other key to exit");
            input = option.nextLine().toLowerCase();
            
            
        }
        
        
    }
    
    // method to print the series report
    public static void printReport(ArrayList<Series> seriesList){
        
        //for loop iterates over the array list and prints the details
        for(int i = 0; i < seriesList.size(); i++){
         
            System.out.println("Series "+ i+1);
            System.out.println("----------------------------------");
            System.out.println("Series ID: "+seriesList.get(i).SeriesId);
            System.out.println("Series Name: "+seriesList.get(i).SeriesName);
            System.out.println("Series Age Restriction: "+seriesList.get(i).SeriesAge);
            System.out.println("Series Number of Episodes: "+seriesList.get(i).SeriesNumberOfEpisodes);
            System.out.println("-----------------------------------");
                       
        }
    }
    
    //method to delete a series from the list
    public static void deleteSeries(ArrayList<Series> seriesList){
        
        //promting user for the series ID that has to be deleted
        System.out.print("Enter series ID to delete >> ");
        
        Scanner searchTerm = new Scanner(System.in);
        String id = searchTerm.nextLine().trim();
        
        
        boolean found = false;
        int foundId = 0;
        
        //code logic to verify the id that is entered by the user.
        for(int i = 0; i < seriesList.size(); i++){
            if(id.equals(seriesList.get(i).SeriesId.trim())){
                // found is set to true when the ID is found to be in the array list
                found = true;
                foundId = i;
                
            }
        }
        
        //logic if the id is valid and is found
        if(found){
            
            //while loop to execute deletion logic and validate whether user is sure of their action to delete
            while(true){
                System.out.println("Are you sure you want to delete series "+seriesList.get(foundId).SeriesId+" from the system? Yes (y) to delete");
                Scanner confirmDelete = new Scanner(System.in);
                String confirmation = confirmDelete.nextLine().trim().toLowerCase();
                String idDelete = seriesList.get(foundId).SeriesId;
                if(confirmation.equals("y")){
                    seriesList.remove(foundId);
                    System.out.println("----------------------------------");
                    System.out.println("Series with ID: "+idDelete+" was deleted");
                    System.out.println("----------------------------------");
                    break;
                }
                System.out.println("----------------------------------");
                System.out.println("Deletion was cancelled");
                System.out.println("----------------------------------");
                break;
            }
            
            
        }else{
            System.out.println("----------------------------------");
            System.out.println("Series with ID: "+id+" not found");
            System.out.println("----------------------------------");
        }
    }
    
    //method to update a series
    public static void update(ArrayList<Series> seriesList){
    
        //promting user for id of series to be deleted
        System.out.print("Enter series ID to update >> ");
        
        Scanner searchTerm = new Scanner(System.in);
        String id = searchTerm.nextLine().trim();
        boolean found = false;
        int foundId = 0;
        for(int i = 0; i < seriesList.size(); i++){
            if(id.equals(seriesList.get(i).SeriesId.trim())){
                //found set to true if the series is found
                found = true;
                foundId = i;
                
            }
        }
        
        if(found){
            //helper of update method to update a series
            updateCapture(seriesList,foundId,seriesList.get(foundId).SeriesId.trim());
            
        }else{
            System.out.println("----------------------------------");
            System.out.println("Series with ID: "+id+" not found");
            System.out.println("----------------------------------");
        }
    }
    
    public static void SearchSeries(ArrayList<Series> seriesList){
    
        //promting user for input
        System.out.print("Enter series ID to search >> ");
        
        Scanner searchTerm = new Scanner(System.in);
        String id = searchTerm.nextLine().trim();
        
        boolean found = false;
        int foundId = 0;
        for(int i = 0; i < seriesList.size(); i++){
            if(id.equals(seriesList.get(i).SeriesId.trim())){
                //setting found to true if the id is valid
                found = true;
                foundId = i;
                
            }
        }
        
        if(found){
            //displating the details of te series that was found
            System.out.println("---------------------------------");
            System.out.println("Series ID: "+seriesList.get(foundId).SeriesId);
            System.out.println("Series Name: "+seriesList.get(foundId).SeriesName);
            System.out.println("Series Age Restriction: "+ seriesList.get(foundId).SeriesAge);
            System.out.println("Series Number of Episodes: "+seriesList.get(foundId).SeriesNumberOfEpisodes);
            System.out.println("----------------------------------");
        }else{
            System.out.println("----------------------------------");
            System.out.println("Series with ID: "+id+" not found");
            System.out.println("----------------------------------");
        }
        
    
    }
    
    public static void updateCapture(ArrayList<Series> seriesList,int indexRemove,String seriesId){
        
        //
        Series newSeries = new Series();
        
        //promting user for details of the series that is being updated
        newSeries.SeriesId = seriesId;
        System.out.print("Enter series name: >> ");
        Scanner nameInput = new Scanner(System.in);
        String name = nameInput.nextLine();
        newSeries.SeriesName = name;
        
        
        System.out.print("Enter series age restriction: >> ");
        
        //validating correct input from user
        boolean invalid = true;
        while(invalid){
            int age = 0;
            try{
                Scanner ageInput = new Scanner(System.in);
                age = ageInput.nextInt();
                
                //validating the age iput
                if(age >=2 && age<=18){
                newSeries.SeriesAge = String.valueOf(age);
                break;
                }
                //error messages for wrong input
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }catch(InputMismatchException e){
                System.out.println("You have entered an incorrect series age (No letters)!!!");
                System.out.print("Please re-enter the series age >> ");
            }
   
        }
        System.out.print("Enter series number of episodes for " +name+ ": >> ");
        
        while(true){
            //input validation logic
            try{
                Scanner numberInput = new Scanner(System.in);
                int number = numberInput.nextInt();
                newSeries.SeriesNumberOfEpisodes = String.valueOf(number);
                break;
            }catch(InputMismatchException e){
                System.out.println("You have entered an incorrect number of episodes (No letters)!!!");
                System.out.print("Please re-enter number of episodes >> ");
            }
        
        }
        
        //removing the series and adding it to the array list with the new details
        seriesList.remove(indexRemove);
        seriesList.add(newSeries);
        System.out.println("*******************************************");
        System.out.println("The series has been updated successfully");
        System.out.println("*******************************************");
        
    }
    
    
    public static void CaptureSeries(ArrayList<Series> seriesList){
        
        
        Series newSeries = new Series(); // new series object
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("******************************");
        
        //promting user for series details
        System.out.print("Enter series id: >> ");
        Scanner idInput = new Scanner(System.in);
        String id = idInput.nextLine();
        newSeries.SeriesId = id;
        
        System.out.print("Enter series name: >> ");
        Scanner nameInput = new Scanner(System.in);
        String name = nameInput.nextLine();
        newSeries.SeriesName = name;
        
        
        System.out.print("Enter series age restriction: >> ");
        
        //input validation logic
        boolean invalid = true;
        while(invalid){
            int age = 0;
            try{
                Scanner ageInput = new Scanner(System.in);
                age = ageInput.nextInt();
                
                if(age >=2 && age<=18){
                newSeries.SeriesAge = String.valueOf(age);
                break;
                }
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }catch(InputMismatchException e){
                System.out.println("You have entered an incorrect series age (No letters)!!!");
                System.out.print("Please re-enter the series age >> ");
            }
   
        }
        System.out.print("Enter series number of episodes for " +name+ ": >> ");
        
        while(true){
            try{
                Scanner numberInput = new Scanner(System.in);
                int number = numberInput.nextInt();
                newSeries.SeriesNumberOfEpisodes = String.valueOf(number);
                break;
            }catch(InputMismatchException e){
                System.out.println("You have entered an incorrect number of episodes (No letters)!!!");
                System.out.print("Please re-enter number of episodes >> ");
            }
        
        }
        
        seriesList.add(newSeries);
        System.out.println("*******************************************");
        System.out.println("The series has been processed successfully");
        System.out.println("*******************************************");
        
    }
    
    
}
    

