package fr.android.androidexercises;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Joris on 22/01/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest extends TestCase {

    @Mock
    LoginActivity activity;
    @InjectMocks
    LoginPresenter loginPresenter;
    @Test
    public void testCheckCredentials() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("password");
        // Then
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);
    }

    @Test
    public void testCheckCredentials2() throws Exception {
        // Given
        // When
        loginPresenter.checkCredentials("01");
        // Then
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);
    }

}