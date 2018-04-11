package org.thoughtcrime.securesms.search.model;

import android.support.annotation.NonNull;

import org.thoughtcrime.securesms.database.CursorList;
import org.thoughtcrime.securesms.database.model.ThreadRecord;
import org.thoughtcrime.securesms.recipients.Recipient;

import java.util.List;

/**
 * Represents an all-encompassing search result that can contain various result for different
 * subcategories.
 */
public class SearchResult {

  public static final SearchResult EMPTY = new SearchResult(CursorList.emptyList(), CursorList.emptyList(), CursorList.emptyList());

  private final CursorList<Recipient>     contacts;
  private final CursorList<ThreadRecord>  conversations;
  private final CursorList<MessageResult> messages;

  public SearchResult(@NonNull CursorList<Recipient>     contacts,
                      @NonNull CursorList<ThreadRecord>  conversations,
                      @NonNull CursorList<MessageResult> messages)
  {
    this.contacts      = contacts;
    this.conversations = conversations;
    this.messages      = messages;
  }

  public List<Recipient> getContacts() {
    return contacts;
  }

  public List<ThreadRecord> getConversations() {
    return conversations;
  }

  public List<MessageResult> getMessages() {
    return messages;
  }


  public int size() {
    return contacts.size() + conversations.size() + messages.size();
  }

  public void close() {
    contacts.close();
    conversations.close();
    messages.close();
  }
}
