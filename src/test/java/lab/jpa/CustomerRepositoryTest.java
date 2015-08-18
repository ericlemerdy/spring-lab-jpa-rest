package lab.jpa;

import lab.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void should_find_by_last_name() throws Exception {
        customerRepository.save(new Customer("Eric", "Le Merdy"));

        assertThat(customerRepository.findByLastName("Le Merdy"), hasSize(1));
        assertThat(customerRepository.findByLastName("Le Merdy").get(0).toString(), is("Customer[id=1, firstName='Eric', lastName='Le Merdy']"));
    }
}