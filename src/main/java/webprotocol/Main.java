package webprotocol;



import lombok.SneakyThrows;

import java.util.List;

public class Main {


    @SneakyThrows
    public static void main(String[] args) {

         Integer idUser = 7;

        User createdUser = HttpUtilClient.postRequest(newUser());
        System.out.println("1.1) creating a new user :\n" + createdUser);
        System.out.println("---------------------------------------------");

        User user = HttpUtilClient.getRequest(idUser);
        user.setName("John");
        user.setUserName("Doe");
        user = HttpUtilClient.putRequest(user.getId(), user);
        System.out.println("---------------------------------------------");


        int statusResponse = HttpUtilClient.deleteRequest(idUser);
        System.out.println("status response is: " + statusResponse);
        System.out.println("---------------------------------------------");


        List<User> users = HttpUtilClient.getRequestAllUsers();
        users.forEach(System.out::println);
        System.out.println("---------------------------------------------");


        User getUserById = HttpUtilClient.getRequestByUserId(idUser);
        System.out.println("user info by id :" + idUser + "\n" + getUserById);
        System.out.println("---------------------------------------------");


        users = HttpUtilClient.getRequestUserByName(getUserById.getUserName());
        System.out.println("user info by Name :" + getUserById.getUserName() + "\n" + users);
        System.out.println("---------------------------------------------");


        String  allCommentToLastPostOfUser = HttpUtilClient.getRequestCommentsOfLastPost(user);
        System.out.println(allCommentToLastPostOfUser);
        System.out.println("---------------------------------------------");

        List<UserTask> allOpenedTaskOfUser = HttpUtilClient.getRequestByTasks(user);
        allOpenedTaskOfUser.forEach(System.out::println);
    }

    public static User newUser() {
        return new User.UserBuilder()
                .id(13)
                .name("Roman Petrenko")
                .userName("Romchansky")
                .email("petrenko.roman@hotmail.com")
                .address(new Address.AddressBuilder()
                        .street("St Claude Ave")
                        .apartment("Apt. 4808")
                        .city("New Orleans")
                        .zipcode("704545")
                        .geo(new Geo.GeoBuilder()
                                .latitude(29.58)
                                .longitude(90.06)
                                .build())
                        .build())
                .phoneNumber("+38066666666")
                .website("https://github.com/Romchansky")
                .company(new Company.CompanyBuilder()
                        .nameCompany("Sun microsystems")
                        .catchPhrase("Hello world")
                        .bs("Java").build())
                .build();
    }


}
