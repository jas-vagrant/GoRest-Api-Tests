package users.getAll;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAllUserResponse {

    @Setter
    private int statusCode;

    private List<Data> data;
    private Meta meta;

    public boolean hasMaleUser(){
        return data.stream()
                .anyMatch(data1 -> data1.getGender().equals("male"));
    }

    @Getter
    public static class Meta {
        private Pagination pagination;
    }

    @Getter
    public static class Data {
        private String gender;
        private String name;
        private String id;
        private String email;
        private String status;
    }

    @Getter
    public static class Pagination {
        private String total;
        private String pages;
        private String limit;
        private Links links;
        private String page;
    }

    @Getter
    public static class Links {
        private String next;
        private String current;
        private String previous;
    }
}
