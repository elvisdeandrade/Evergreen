package br.com.evergreenapi.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evergreenapi.Domain.Feed;
import br.com.evergreenapi.Exceptions.FeedNotFoundException;
import br.com.evergreenapi.Repositories.FeedRepository;

@RestController
@RequestMapping(value = "/api/v1/feeds")
public class FeedsController {
    @Autowired
    FeedRepository feeds;
    
    @RequestMapping(value = "")
	public List<Feed> feeds() {
		return (List<Feed>) feeds.findAll();
	}

    @RequestMapping(value = "/{id}")
	public Optional<Feed> findById(@PathVariable("id") Long id) {
		Optional<Feed> feed = feeds.findById(id);

        if(feed == null) throw new FeedNotFoundException(id, "Feed Not Found, id: ");

        return feed;
	}
}
