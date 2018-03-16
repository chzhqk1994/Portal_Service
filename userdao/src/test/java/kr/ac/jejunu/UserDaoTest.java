package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;  // 테스트할때 hamcrest 라이브러리를 많이 쓴다
import static org.hamcrest.MatcherAssert.*;  // static 을 붙이면 static 메소드를 쓸 수 있다


public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setup(){
        userDao = new UserDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException{
        // Exception 처리는 잘 알때 사용, 확신이 없을 땐 알아서 하게 내버려 둬야한다
        // 내가 처리할 수 없는 Exception 은 throw 하는게 맞다.
            UserDao userDao = new UserDao();
            int id = 1;
            User user = userDao.get(id);
            assertThat(user.getId(), is(1));
            assertThat(user.getName(), is("허윤호"));
            assertThat(user.getPassword(), is("1234"));
        }

    @Test
    public void add() throws SQLException, ClassNotFoundException{
    User user = new User();
    user.setName("헐크");
    user.setPassword("1111");
    Integer id = userDao.insert(user);  // 헐크와 1111을 DB에 넣고, 헐크에 해당하는 ID 만 리턴받기로 함

    User insertedUser = userDao.get(id);
    assertThat(insertedUser.getId(), is(id)); // inserted 된 id  가 위에있는 user 의 Id 와 같는지 판별
    assertThat(insertedUser.getName(), is(user.getName()));
    assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}

