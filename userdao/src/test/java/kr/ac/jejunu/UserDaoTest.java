package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;  // 테스트할때 hamcrest 라이브러리를 많이 쓴다
import static org.hamcrest.MatcherAssert.*;  // static 을 붙이면 static 메소드를 쓸 수 있다


public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException{{
        // Exception 처리는 잘 알때 사용, 확신이 없을 땐 알아서 하게 내버려 둬야한다
        // 내가 처리할 수 없는 Exception 은 throw 하는게 맞다.
            UserDao userDao = new UserDao();
            int id = 1;
            User user = userDao.get(id);
            assertThat(user.getId(), is(1));
            assertThat(user.getName(), is("허윤호"));
            assertThat(user.getPassword(), is("1234"));
        }
    }
}
