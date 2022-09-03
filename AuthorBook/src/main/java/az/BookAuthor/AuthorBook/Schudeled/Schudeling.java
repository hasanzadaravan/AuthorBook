package az.BookAuthor.AuthorBook.Schudeled;

import az.BookAuthor.AuthorBook.Service.AuthorImp;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schudeling {
    private final AuthorImp authorService;
    public Schudeling(AuthorImp authorService) {
        this.authorService = authorService;
    }
   @Scheduled(cron = "0/2 * * * * ?")
    @SchedulerLock(name = "something", lockAtLeastForString = "PT5M", lockAtMostForString = "PT5M")
    void something() {
        System.out.println("DDDDD1");
        authorService.scheduledTask();
    }
}
