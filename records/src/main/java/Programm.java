import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Programm {
    private static String[] firstNameMale = {"Андрей", "Владимир", "Александр", "Геннадий", "Петр", "Сергей", "Алексей",
            "Константин", "Георгий", "Олег", "Михаил", "Евгений", "Роман", "Павел", "Илья", "Иван", "Артем", "Станислав",
    "Данил", "Максим"};
    private static String[] firstNameFemale = {"Мария", "Анна", "Ирина", "Дарья", "Елена", "Ольга", "Виктория",
            "Надежда", "Светлана", "Юлия", "Яна","Галина", "Татьяна", "Александра", "Алина", "Кристина", "Анастасия",
    "Евгения", "Карина", "Марина"};

    private static String[] surNameMale = {"Олегович", "Андреевич", "Константинович", "Алексеевич", "Сергеевич", "Георгиевич",
    "Петрович", "Геннадьевич", "Александрович", "Владимирович", "Олеговна","Андреевна", "Константиновна", "Алексеевна",
    "Сергеевна", "Георгиевна", "Петровна", "Геннадьевна", "Александровна", "Владимировна", "Ильич", "Максимов", "Романович",
    "Павлович", "Атемович", "Евгеньевич", "Данилович", "Станиславович", "Михайлович", "Иванович"};

    private static String[] surNameFemale = {"Олеговна","Андреевна", "Константиновна", "Алексеевна",
            "Сергеевна", "Георгиевна", "Петровна", "Геннадьевна", "Александровна", "Владимировна", "Романовна", "Ивановна",
    "Максимовна", "Артемовна", "Евгеньевна", "Даниловна", "Павловна", "Станиславовна", "Михайловна", "Ильинична"};

    private static String[] lastNameMale = {"Петров", "Иванов", "Сидоров", "Морозов", "Конюхов", "Сорокин", "Дикарев",
    "Колесников", "Самойлов", "Горбунов", "Калмыков", "Марков", "Соколов", "Смирнов", "Кузнецов", "Лебедев", "Егоров",
    "Павлов", "Орлов", "Зайцев"};

    private static String[] lastNameFemale = {"Петрова","Иванова", "Сидорова", "Морозова", "Конюхова", "Сорокина",
            "Дикарева", "Колесникова", "Самойлова", "Горбунова", "Калмыкова", "Маркова", "Соколова", "Смирнова", "Кузнецова",
            "Лебедева", "Егорова", "Павлова", "Орлова", "Зайцева"};

    private static String[] playName = {"На дне", "Вишневый сад", "Четырнадцатое июля", "Соната призраков", "Жизнь человека",
    "Игра интересов", "Павел I", "Синяя птица", "Стелла", "Почта", "Пигмалион", "Изгнанники", "Человек", "Мечтатели",
    "Корабль", "Квартира", "Бег", "Атилла", "Опера", "Самоубийца", "Потеря", "Собака", "Клоун", "Баня", "Свадьба", "Таня",
    "Наш город", "Переполох", "Машенька", "Долгий день уходит в ночь", "Мухи", "Дракон", "Золотая антилопа", "Служанки", "Банкрот",
    "Смерть коммивояжера", "Певица", "Дом на окраине", "Глобус", "Мышеловка", "Вдова Капет", "Обыкновенное чудо",
            "Визит старой дамы", "Оглянись во гневе", "Чайная", "Семья", "Призраки среди нас", "В поисках радости",
    "Носорог", "Сторож", "Иркутская история", "Картотека", "Коллекция", "Физики", "Дознание", "Расследование", "Старший сын",
    "Варшавская история", "Утиная охота", "Самый правдивый", "Осення соната", "Минута покоя", "Свободная пара", "Роза",
    "Гипотеза", "Змеиная кожа", "Щи", "Там вдали", "Разбитый кувшин", "Фауст", "Женитьба", "Маскарад", "Кокульный домик",
    "Страна чудес", "Ревизор", "Смотритель", "Стакан воды", "Деньги", "Месяц в деревне", "Маленькая история", "Хулиган",
    "Гроза", "Буря", "Полет", "Враг", "Хранитель", "Банкротство", "Мелодия жизни", "Враг народа", "Русалочка", "Принц",
    "Власть тьмы", "Слепые", "Суеверие", "Одинокие", "Глупец и смерть", "Счастливые", "Танцы под дождем", "Чайка",
    "Кукушка", "Три сестры", "Простая девушка", "Зори", "Король мира", "Тайна семьи", "Новая страница", "Песнь богатыря"};

    private static String[] author = {"М. Горький", "А. Чехов", "Р. Роллан", "А. Стриндберг", "Л. Андреев", "Х. Мартинес",
    "Д. Мережковский", "М. Метерлинк", "Г. Ксенопулос", "Р. Тагор", "Д. Шоу", "Д.Джойс", "Э. Толлер", "Р. Музиль",
            "Н. Евреинов", " Н. Белоусов", "К. Кокто", "М. Булгаков", "Е. Замятин", "Н. Короблев"};


    private static String[] sex = {"м.", "ж."};

    private static String[] RoleName = {"Машенька", "Девочка со двора", "Служанка", "Анастасия",
     "Соня",  "Старушка", "Дочь служанки", "Матушка", "Королева", "Таисия", "Екатерина", "Марья Ивановна", "Катерина",
    "Клавдия Петровна",  "Король", "Андрюша", "Отец", "Петруша", "Петр Иванович", "Петр Иванович",
            "Мечтатель", "Аркадий Иванович","Творец", "Писатель", "Художник", "Федор Петрович"};


    private static String addAuthor(){
        Random rand = new Random();
        int index = rand.nextInt(author.length);
        return "'"+author[index]+"'";
    }

    private static String addName(String[] mas){
        Random rand = new Random();
        int index = rand.nextInt(mas.length);
        return "'"+mas[index]+"'";
    }

    private static String addDate(){
        return "'" + (int)(Math.random()*50+1900)+ "-" + (int)(Math.random()*11+1) + "-" + (int)(Math.random()*26+1) + "'";
    }

    private static String addDatePerformance(){
        return "'" + (int)(Math.random()*10+2018)+ "-" + (int)(Math.random()*11+1) + "-" + (int)(Math.random()*26+1) + "'";
    }
    private static String addDateContract(){
        return "'" + (int)(Math.random()*4+2015)+ "-" + (int)(Math.random()*11+1) + "-" + (int)(Math.random()*26+1) + "'";
    }


    private static String addAge(){
        return "'" + (int)(Math.random()*50+18)+"'";
    }

    private static int addRandomId (int c) {
        Random rand = new Random( ) ;
        return 1 + rand.nextInt (c) ;
    }

    private static String addTime(){
        String min[] = {"00", "30"};
        int i = (int)(Math.random()*2);
        return "'" + (int)(Math.random()*10+12)+ ":" + min[i]+":00'";
    }


    public static void main(String[] args){
        try{
            String url = "jdbc:mysql://localhost:3306/Theater?serverTimezone=Europe/Moscow&useSSL=false" +
                    "&useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password ="223344ya";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = DriverManager.getConnection(url, username, password)){
                System.out.println("Connection successful!");
                Statement statement = connection.createStatement();
                Statement st1 = connection.createStatement();
                Statement st2 = connection.createStatement();
                Statement st3 = connection.createStatement();
                Statement st4 = connection.createStatement();
                String mySqlInsert;

                //актеры +++
               for(int i = 0; i < 1000; i++){
                    if(i % 2 == 1)
                        mySqlInsert = "insert into Actors(lastname, firstname, surname, age, sex)" +
                                "values(" + addName(lastNameMale) +
                                ","+ addName(firstNameMale)+","+addName(surNameMale)+","+addAge()+", '"+sex[0]+ "')";
                    else mySqlInsert = "insert into Actors(lastname, firstname, surname, age, sex)" +
                            "values(" + addName(lastNameFemale) +
                            ","+ addName(firstNameFemale)+","+addName(surNameFemale)+","+addAge()+", '"+sex[1]+ "')";
                    statement.executeUpdate(mySqlInsert);
                }
                System.out.println("Actors added!");

                // Пьесы +++
                for(int i = 0; i < 100;i++){
                    mySqlInsert = "insert into Play(play_name, author, date_of_creation)" +
                            "values( '"+playName[i]+"',"+addAuthor()+ ","+addDate()+")";
                    statement.executeUpdate(mySqlInsert);
                }
                System.out.println("Plays added!");

                //Роль в пьесе
                Random rand = new Random();
                int indexPlay = 0;
                int countRoleInPlay = 0;
                for(int i = 1; i <= 100; i++){
                    indexPlay = rand.nextInt(17)+1;
                    for(int j = 1; j <= indexPlay; j++){
                        if(j % 2 == 1){
                            mySqlInsert = "insert into Role_in_the_play(role_name, play_id, role_type_id)" +
                                    "values("+addName(RoleName)+","+"'"+i+"',"+"'1')";
                        } else{
                            mySqlInsert = "insert into Role_in_the_play(role_name, play_id, role_type_id)" +
                                    "values("+addName(RoleName)+","+"'"+i+"',"+"'2')";
                        }
                        statement.executeUpdate(mySqlInsert);
                        countRoleInPlay++;
                    }
                }
                System.out.println("Role in the play added!"+countRoleInPlay);

                //Постановка +++
                int indexProduction = 0;
                int indexDirector = 0;
                int indexAllProduction = 0;
                for(int i = 1; i<=100;i++){
                    indexProduction = rand.nextInt(3)+1;
                    for(int j = 0; j < indexProduction; j++){
                        indexDirector = rand.nextInt(10)+1;
                        mySqlInsert = "insert into Production(production_name, director_id, play_id)" +
                                "values((select play_name from Play where play_id="+ i+"), '"+indexDirector+"',"+
                                "'"+i+"')";
                        statement.executeUpdate(mySqlInsert);
                        indexAllProduction++;
                    }
                }
                System.out.println("Production added!"+indexAllProduction);

                //Достижения актера ++
                int indexAwards =0;
                int randomActor = 0;
                int countAwards = 0;
                for(int i =1;i < 51; i++){
                    randomActor = rand.nextInt(1000)+1;
                    indexAwards =rand.nextInt(10)+1;
                    for(int j = 1; j<=indexAwards;j++){
                        mySqlInsert = "insert into Actor_awards(actor_id, awards_id)" +
                                "values('"+randomActor+"','"+addRandomId(10)+"')";
                        statement.executeUpdate(mySqlInsert);
                        countAwards++;
                    }
                }
                System.out.println("Actor awards added!"+countAwards);

                //Роли ++
                int indexPlay_id =0;
                int indexCountRole = 0;
                int countRoles = 0;
                for(int i = 1; i<= indexAllProduction; i++) {
                    ResultSet resultPlay = st1.executeQuery("select * from Production where production_id=" + i);
                    while (resultPlay.next()) {
                        indexPlay_id = resultPlay.getInt(4);
                    }
                    ResultSet resultRolesNew = st3.executeQuery("select * from Role_in_the_play where " +
                            "play_id=" + indexPlay_id);
                    while (resultRolesNew.next()) {
                        countRoles = rand.nextInt(3)+1;
                        for(int j = 0; j<countRoles;j++){
                            mySqlInsert = "insert into Roles(role_name, production_id, role_in_the_play_id, actor_id) " +
                                    "values('" + resultRolesNew.getString(2) + "', '" + i + "', '" +
                                    resultRolesNew.getInt(1) + "'," + addRandomId(1000) + ")";
                            statement.executeUpdate(mySqlInsert);
                            indexCountRole++;
                        }
                    }
                }
                System.out.println("Roles added!"+indexCountRole);

                //Спектакль ++
                int indexPerformance = 0;
                int countPerformance = 0;
                int randType = 0;
                for(int i =1; i<= indexAllProduction;i++){
                    indexPerformance = rand.nextInt(50)+25;
                    for(int j =0; j<indexPerformance;j++){
                        randType = rand.nextInt(2)+1;
                            mySqlInsert = "insert into Performance(performance_name, production_id,date_performance, start_time," +
                                    "performance_type_id)" +
                                    "values((select production_name from Production where production_id ="+i+"), '"+i+"', "
                                    +addDatePerformance()+", "+ addTime()+", '"+randType+"')";
                            countPerformance++;
                        statement.executeUpdate(mySqlInsert);
                    }
                }
                System.out.println("Performance added!"+ countPerformance);

              //Состав спектакля
                int indexPerformance_id =0;
                int indexTeam = 1;
                int countTeam = 0;
                int roleCountTeam = 0;
                int randCountTeam =0;

                for(int i = 1; i<=countPerformance;i++){
                    ArrayList<Integer> vecRole = new ArrayList<Integer>();
                    ResultSet resultPerformance = st1.executeQuery("select * from Performance where " +
                            "performance_id="+i);
                    while(resultPerformance.next()){
                        indexPerformance_id = resultPerformance.getInt(3);
                    }
                    ResultSet resultR = st2.executeQuery("select * from Roles where " +
                            "production_id="+ indexPerformance_id);
                    while(resultR.next()){
                        vecRole.add(resultR.getInt(1));
                    }
                    Collections.shuffle(vecRole);
                    if(vecRole.size() > 16){
                        randCountTeam = 16;
                    } else {
                        randCountTeam = vecRole.size();
                    }
                    for(int j = 0; j < randCountTeam; j++){
                        mySqlInsert = "insert into Team_performance(number_team, performance_id, role_id)" +
                                "values('"+indexTeam+"', '"+i+"', '"+vecRole.get(j)+"')";
                        statement.executeUpdate(mySqlInsert);
                        countTeam++;
                    }
                    indexTeam++;
                }

                System.out.println("Team performance added!"+countTeam);


                //Контракт +++
                int salary = 0;
                int countContract = 0;
                for(int i = 1; i<=indexCountRole;i++){
                    salary = rand.nextInt(50000)+30000;
                    mySqlInsert = "insert into Contract(assignment_date, salary, role_id, actor_id)" +
                            "values("+ addDateContract() + ", '" + salary+"', '"+i+"',"+"(select actor_id from Roles where " +
                            "role_id="+i+"))";
                    statement.executeUpdate(mySqlInsert);
                    countContract++;
                }
                System.out.println("Contract added!"+countContract);
            }

        } catch (Exception ex ) {
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

};

