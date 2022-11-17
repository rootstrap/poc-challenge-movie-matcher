import { StyleSheet } from 'react-native';

import { SCREEN_BACKGROUND } from 'theme/colors';

export default StyleSheet.create({
  screenContainer: {
    backgroundColor: '#F0F0F0',
    flex: 1,
  },
  header: {
    alignItems: 'center',
    backgroundColor: '#260065',
    flexDirection: 'row',
    height: 56,
    paddingHorizontal: 26,
  },
  headerIcon: {
    marginRight: 19,
  },
  headerTitle: {
    color: 'white',
  },
  bold: {
    fontWeight: 'bold',
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: SCREEN_BACKGROUND,
  },
});
