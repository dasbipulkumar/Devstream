package com.devstream.provider.stackoverflow

import com.devstream.provider.base.ProviderBasedEvent

/**
  * Created by bipulk on 10/7/16.
  */

//case class StackOverflowEvent(eventId: String, userId: String, link: String) extends ProviderBasedEvent

case class QuestionAsked(eventId: String, userId: String, link: String, questionId: String, title: String)
  extends ProviderBasedEvent

case class QuestionAnswered(eventId: String, userId: String, link: String, questionId: String, title: String)
  extends ProviderBasedEvent

case class PostComment(eventId: String, userId: String, link: String, questionId: String, postId : String, postType: String,
  title: String, details: String)
  extends ProviderBasedEvent

