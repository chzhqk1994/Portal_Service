package kr.ac.jejunu;

public class DaoFactory {
    private UserDao userDao;

    public UserDao getUserDao() {
        return new UserDao(new JejuConnectionMaker());
    }
}
