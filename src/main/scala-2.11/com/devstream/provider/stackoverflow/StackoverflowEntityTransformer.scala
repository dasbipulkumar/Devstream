package com.devstream.provider.stackoverflow

import com.devstream.apiclients.stackexchange.response._
import com.devstream.provider.base.{DevStreamEvent, ProviderBasedEvent}

import scala.util.Try

/**
  * Created by bipulk on 10/7/16.
  */
object StackoverflowEntityTransformer {

  private val provider = "stackoverflow"

  def trasform[T <: UserTimelineBase](userTimelineBase: T): Option[AnyRef] = {

    Try {
      userTimelineBase match {

        case event: UserTimeLineQuestionAsked => {

          DevStreamEvent(provider, event.timelineType.toString, QuestionAsked(event.eventId, event.userId, event.link, event.questionId, event.title ), event.timeStamp)

        }

        case event: UserTimeLineQuestionAnswered => {

          DevStreamEvent(provider, event.timelineType.toString, QuestionAnswered(event.eventId, event.userId, event.link, event.questionId, event.title ), event.timeStamp)

        }

        case event: UserTimeLineComment => {

          DevStreamEvent(provider, event.timelineType.toString, PostComment(event.eventId, event.userId, event.link, event.postId, event.postType.toString, event.questionId, event.title , event.detail), event.timeStamp)
        }

        case event: UserTimeLineBadge => {

          None
        }
      }

    }
  }.toOption
}
