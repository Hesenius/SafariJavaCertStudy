/*open*/ module mymods.service {
  exports service to mymods.Client, does.not.exist;
  opens service to mymods.Client, does.not.exist;
  // provides <service interface> with <service impl>
}
