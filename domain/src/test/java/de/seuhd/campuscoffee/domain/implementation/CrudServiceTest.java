package de.seuhd.campuscoffee.domain.implementation;

import de.seuhd.campuscoffee.domain.model.objects.Review;
import de.seuhd.campuscoffee.domain.ports.data.CrudDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {

   @Mock
   private CrudDataService<Review, Long> dataService;

   private CrudServiceImpl<Review, Long> service;

   @BeforeEach
   void beforeEach() {
       service = new CrudServiceImpl<Review, Long>(Review.class){
           @Override
           protected CrudDataService<Review, Long> dataService(){
               return dataService;
           }
       };
   }

   @Test
   void clearGoesToDataService(){
       service.clear();
       verify(dataService).clear();
   }
}
