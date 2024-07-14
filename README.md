# Employee
Java 

Based on the following Employee structure JSON Array 
[ 
    { 
        "FirstName": "Sam" , 
        "LastName": "Jackson" , 
        "EmployeeID": 1000 , 
        "Designation": "Manager", 
        "KnownLanguages": [ 
            { 
               "LanguageName": "Java", 
               "ScoreOutof100": 90 
            }, 
            { 
               "LanguageName": "C#", 
               "ScoreOutof100": 50  
            }, 
            { 
                "LanguageName": "C++", 
                "ScoreOutof100": 80 
            } 
 
        ] 
    }, 

 
 
 
    { 
        "FirstName": "John" , 
        "LastName": "Adamo" , 
        "EmployeeID": 2000 , 
        "Designation": "Developer", 
        "KnownLanguages": [ 
            { 
               "LanguageName": "Perl", 
               "ScoreOutof100": 30 
            }, 
            { 
               "LanguageName": "Java", 
               "ScoreOutof100": 65 
            }, 
            { 
                "LanguageName": "C++", 
                "ScoreOutof100": 70 
            } 
        ] 
    } 
] 

My program do the following: 
1- Read JSON Array   
2- Add new Employee using the above-mentioned structure   
3- Give the user the ability to search for a specific EmployeeID or Designation and retrieve the 
search result from the JSON array  
4- Delete Item from JSON Array   
Service Oriented Architecture Course 
5- Update the Employee with ID = 2000 from Developer to Team Leader.  
6- Retrieve the employees who know the Java language with score higher than 50 and sort the 
result in ascending order. 