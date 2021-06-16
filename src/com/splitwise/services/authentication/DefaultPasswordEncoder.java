package com.splitwise.services.authentication;

public class DefaultPasswordEncoder implements PasswordEncoder{

    private static DefaultPasswordEncoder INSTANCE;
    private DefaultPasswordEncoder(){};
    public static DefaultPasswordEncoder getINSTANCE(){
        if(INSTANCE==null) {
            synchronized (DefaultPasswordEncoder.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DefaultPasswordEncoder();
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public String encode(String password, String username) {
        return password;
    }
}
