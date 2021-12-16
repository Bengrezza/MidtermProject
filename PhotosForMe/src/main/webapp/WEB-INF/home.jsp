<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Find Photographers Easy | Photography For Me</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" type="text/css" media="screen" href="styles/main.css" />
  </head>
  <body>
    <header>
      <div class="container">
        <nav>
          <div class="nav-brand">
            <a href="home.do">
              <img src="images/logo.png" alt="Photography For Me" />
            </a>
          </div>
		  <div class="nav-title">
			  <p>Photography For Me</p>
          </div>
          <div class="burger-menu-icon">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
          </div>
          <ul class="nav-list">
            <li class="nav-item">
              <a href="home.do">
                <img
                  src="images/logo.png"
                  alt="Photography For Me"
                  class="logo-pic nav-link"
                />
              </a>
            </li>
            <li class="nav-item">
              <a href="login" class="nav-link">Login/Register</a>
            </li>
            <li class="nav-item">
              <a href="gallery.do" class="nav-link">Photographers</a>
            </li>
            <li class="nav-item">
              <a href="#services" class="nav-link">Services</a>
            </li>
            <div class="cta">
              <a href="#" target="_blank" class="btn nav-link">Contact Us</a>
            </div>
          </ul>
        </nav>
      </div>
    </header>

	<main>
		<section id="top-photographers" class="top-photographers">
			<div class="container">
				<div class="top-photography-title">
					<h2>Top Photographers</h2>
				</div>
			</div>
			<ol class="top-photographers-list">
				<li class="top-photographers-item">
					<a href="">Photographer 1</a>
					<p>Rating: 5 Location: Denver, CO</p>
				</li>
				<li class="top-photographers-item">
					<a href="">Photographer 2</a>
					<p>Rating: 5 Location: Denver, CO</p>
				</li>
				<li class="top-photographers-item">
					<a href="">Photographer 3</a>
					<p>Rating: 5 Location: Denver, CO</p>
				</li>
				<li class="top-photographers-item">
					<a href="">Photographer 4</a>
					<p>Rating: 5 Location: Denver, CO</p>
				</li>
				<li class="top-photographers-item">
					<a href="">Photographer 5</a>
					<p>Rating: 5 Location: Denver, CO</p>
				</li>
			</ol>
		</section>

		<section id="recent-comments" class="recent-comments">
			<div class="container">
				<div class="recent-comments-title">
					<h2>Recent Comments</h2>
				</div>
			</div>
			<ul class="recent-comments-list">
				<li class="recent-comments-item">
					<p>Random comment here. More comment stuff this is a very very long comment! WOW it is so long i think it will break everything......</p>
				</li>
				<li class="recent-comments-item">
					<p>Random comment here.</p>
				</li>
				<li class="recent-comments-item">
					<p>Random comment here.</p>
				</li>
				<li class="recent-comments-item">
					<p>Random comment here.</p>
				</li>
				<li class="recent-comments-item">
					<p>Random comment here.</p>
				</li>
			</ul>
		</section>
		
		<section id="mission-statement" class="mission-statement">
			<div class="container">
				<h2>Mission Statement</h2>
				<p>"Photography For Me will connect consumers with great local photographers. It will also give local photographers a platform to manage their business and trade resources. Along the way, Photography For Me will hope to enrich lives of consumers and photographers. In pursuit of this mission, Photography For Me wants to provide the most helpful information possible about photographers to consumers, and the most seam-less business management platform for photographers."</p>
			</div>
		</section>
		
	</main>

    <script src="main.js"></script>
  </body>
</html>
