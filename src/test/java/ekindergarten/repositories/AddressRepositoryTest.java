package ekindergarten.repositories;

import utils.Constans;
import ekindergarten.domain.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class AddressRepositoryTest {
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void shouldFindAllAddressesByCity() {
        //given
        addressRepository.save(createAddress());
        //when
        List<Address> result = addressRepository.findAllByCity(Constans.CITY);
        //then
        Assert.assertEquals(result.size(), 1);
    }

    private Address createAddress(){
        return new Address.Builder()
                .withCity(Constans.CITY)
                .withZipCode(Constans.ZIP_CODE)
                .withStreet(Constans.STREET)
                .withHomeNumber(Constans.HOME_NUMBER)
                .withFlatNumber(Constans.FLAT_NUMBER)
                .build();
    }

}